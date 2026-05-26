<?php

namespace ResumeBuilderVanilla\Controllers;

use ResumeBuilderVanilla\Core\PostRequest;
use ResumeBuilderVanilla\Core\Request;
use ResumeBuilderVanilla\Models\Resume;

class ResumeController
{
    public function store(): string
    {
        $resume = new Resume();
        // $resume->name = $request->name;
        return "Hello!";
    }

    public function callGreeting(Request $request)
    {
        print_r($_POST);
        $request->greet("Hello! World");
    }
}