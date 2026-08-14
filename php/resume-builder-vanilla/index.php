<?php

// Register the Composer autoloader...
require __DIR__ . '/vendor/autoload.php';

use Dotenv\Dotenv;


$dotenv = Dotenv::createImmutable(__DIR__);       //? - EGPCS
$dotenv->load();

require_once 'bootstrap.php';
require_once 'route.php';

//TODO: Implement Maintenance Mode

//TODO: Track overall session time

//TODO: Implement Routing

//TODO: Implement Front Controller


