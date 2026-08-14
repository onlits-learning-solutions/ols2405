<?php

namespace ResumeBuilderVanilla\Core\Services;

use ResumeBuilderVanilla\Core\Container\Component;

#[Component]
interface Request
{
    public function greet(string $greeting);
}