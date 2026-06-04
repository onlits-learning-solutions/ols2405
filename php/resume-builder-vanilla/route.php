<?php

use ResumeBuilderVanilla\Controllers\ResumeController;
use ResumeBuilderVanilla\Core\PostRequest;
use ResumeBuilderVanilla\Models\Resume;

define('VIEW_LOCATION', $_SERVER['DOCUMENT_ROOT'] . '/resources/views/');

$uri = $_SERVER['REQUEST_URI'];

switch ($uri) {
    case '/dashboard':
        include VIEW_LOCATION . 'dashboard.php';
        exit;
        break;
    case '/resume/greeting':
        $resumeController = new ResumeController();
        $resumeController->callGreeting(new PostRequest(''));
        break;
    default:
        echo 'Page not found!';
}