<?php

namespace ResumeBuilderVanilla\Core;

use Override;

class PostRequest implements Request
{
    public function __construct(string $greeting)
    {
        echo $greeting;
    }
    
    public function greet(string $greeting)
    {
        echo $greeting;
    }
}