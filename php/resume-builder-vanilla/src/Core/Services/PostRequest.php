<?php

namespace ResumeBuilderVanilla\Core\Services;

use ResumeBuilderVanilla\Core\Container\Component;

#[Component]
class PostRequest
{   
    public function greet(string $greeting)
    {
        echo $greeting;
    }
}