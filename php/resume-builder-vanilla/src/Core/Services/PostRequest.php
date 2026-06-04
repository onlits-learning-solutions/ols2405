<?php

namespace ResumeBuilderVanilla\Core\Services;

use ResumeBuilderVanilla\Core\Container\Autowired;
use ResumeBuilderVanilla\Core\Container\Component;

#[Component]
class PostRequest
{   
    #[Autowired]
    public function __construct()
    {
        
    }
    
    public function greet(string $greeting)
    {
        echo $greeting;
    }
}