<?php

use ResumeBuilderVanilla\Controllers\ResumeController;
use ResumeBuilderVanilla\Core\Container\ApplicationContext;
use ResumeBuilderVanilla\Core\Services\PostRequest;

$context = new ApplicationContext([
    PostRequest::class,
    ResumeController::class,
]);

$resumeController = $context->getBean('ResumeController::class');

$resumeController->callGreeting();
