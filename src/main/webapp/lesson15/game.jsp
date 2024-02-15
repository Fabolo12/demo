<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Name of quest</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f0f0f0;
            color: #333;
        }

        .container {
            max-width: 600px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .choice-buttons {
            margin-top: 20px;
        }

        a {
            cursor: pointer;
            padding: 10px 15px;
            margin-right: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Name of quest</h1>
    <p>You are in a dark and damp cave. There are three paths: to the left is a narrow passage, to the right is a wide tunnel,
        and straight ahead is a deep chasm.</p>
    <div class="choice-buttons">
        <a href="/JavaRush/lesson15/game-action?question=1&answer=1">Go left</a>
        <a href="/JavaRush/lesson15/game-action?question=1&answer=2">Go right</a>
        <a href="/JavaRush/lesson15/game-action?question=1&answer=3">Go straight</a>
    </div>
</div>
</body>
</html>