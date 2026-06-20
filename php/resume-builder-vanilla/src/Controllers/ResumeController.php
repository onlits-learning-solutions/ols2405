<?php

namespace ResumeBuilderVanilla\Controllers;

use ResumeBuilderVanilla\Core\Container\Autowired;
use ResumeBuilderVanilla\Core\Container\Component;
use ResumeBuilderVanilla\Core\Services\PostRequest;
use ResumeBuilderVanilla\Models\Resume;

#[Component]
class ResumeController
{
    private PostRequest $request;

    #[Autowired]
    public function __construct(PostRequest $request)
    {
        $this->request = $request;
    }

    public function store(): string
    {
        $resume = new Resume();
        // $resume->name = $request->name;
        return "Hello!";
    }

    public function callGreeting()
    {
        $this->request->greet("Hello World! Our DI container is finally working!");
    }
}