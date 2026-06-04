<?php

use ResumeBuilderVanilla\Controllers\Controller;
use ResumeBuilderVanilla\Controllers\ResumeController;
use ResumeBuilderVanilla\Core\Container\ApplicationContext;
use ResumeBuilderVanilla\Core\Container\Autowired;
use ResumeBuilderVanilla\Core\Container\Component;
use ResumeBuilderVanilla\Core\Services\PostRequest;
use ResumeBuilderVanilla\Core\Services\Request;

$context = new ApplicationContext([
    PostRequest::class,
    ResumeController::class,
]);


#[Component]
class Test
{
    private PostRequest $request;

    #[Autowired]
    function __construct(PostRequest $request)
    {
        $this->request = $request; 
    }

    function testGreet()
    {
        $this->request->greet('Hi there! We are experimenting with DI');
    }
}
