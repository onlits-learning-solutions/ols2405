<?php

namespace ResumeBuilderVanilla\Core\Container;

use ReflectionClass;
use ReflectionException;
use RuntimeException;

#[\Attribute]
class Component {}

#[\Attribute]
class Autowired {}

class ApplicationContext
{
    private array $beans = [];

    public function __construct(array $componentClasses)
    {
        foreach ($componentClasses as $class) {
            $this->createBean($class);
        }
    }

    public function createBean(string $class)
    {
        if (isset($this->beans[$class])) {
            return $this->beans[$class];
        }
        try {
            $reflectionClass = new ReflectionClass($class);
            // print_r($reflectionClass);
            $componentAttrs = $reflectionClass->getAttributes(Component::class);

            if (empty($componentAttrs)) {
                throw new RuntimeException("$class is not a component");
            }

            $constructor = $reflectionClass->getConstructor();

            $dependencies = [];

            if ($constructor) {

                $autowiredAttrs = $constructor->getAttributes(Autowired::class);

                foreach ($constructor->getParameters() as $parameter) {
                    $type = $parameter->getType();

                    if (!$type) {
                        throw new RuntimeException("Cannot resolve dependency{$parameter->getName()} in $class");
                    }

                    $dependencyClass = $type->getName();

                    $dependencies[] = $this->createBean($dependencyClass);
                    // var_dump($dependencies);
                }
            }

            $instance = $reflectionClass->newInstanceArgs($dependencies);
            $this->beans[$class] = $instance;

            return $instance;
        } catch (ReflectionException $e) {
            throw new RuntimeException("Failed to create bean: $class", 0, $e);
        }
    }

    public function getBean(string $class)
    {
        return $this->beans[$class] ?? null;
    }
}
