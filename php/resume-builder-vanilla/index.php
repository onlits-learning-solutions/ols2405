<?php

// Register the Composer autoloader...
require __DIR__ . '/vendor/autoload.php';

use Dotenv\Dotenv;
use ResumeBuilderVanilla\Controllers\ResumeController;
use ResumeBuilderVanilla\Core\PostRequest;
use ResumeBuilderVanilla\Models\Resume;

$dotenv = Dotenv::createUnsafeImmutable(__DIR__);       //? - EGPCS
$dotenv->load();

//TODO: Implement Maintenance Mode

//TODO: Track overall session time

//TODO: Implement Routing

//TODO: Implement Front Controller

$uri = $_SERVER['REQUEST_URI'];

switch ($uri) {
    case '/dashboard':
        header('Location:/resources/views/dashboard.php');
        exit;
        break;
    case '/resume/greeting':
        // $resumeController = new ResumeController();
        // $resumeController->callGreeting(new PostRequest('Good Morning!'));
        // $resume = new Resume();
        break;
    default:
        echo 'Page not found!';
}
