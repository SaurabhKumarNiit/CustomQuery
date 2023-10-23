<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert Data Form</title>
</head>
<body>
    <h1>Insert Data Form</h1>
    <form action="/submit" method="post">
        <!-- Name -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <!-- Email ID -->
        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" required><br><br>

        <!-- Phone number (optional) -->
        <label for="phone">Phone number:</label>
        <input type="text" id="phone" name="phone"><br><br>

        <!-- Video requirements -->
        <label for="duration">Video duration:</label>
        <input type="text" id="duration" name="duration" required><br><br>

        <label for="videoType">Type of video:</label>
        <select id="videoType" name="videoType" required>
            <option value="reel">Reel</option>
            <option value="longform">Longform</option>
        </select><br><br>

        <label for="platform">Platform:</label>
        <select id="platform" name="platform" multiple required>
            <option value="YouTube">YouTube</option>
            <option value="Instagram">Instagram</option>
            <option value="LinkedIn">LinkedIn</option>
            <option value="Other">Other</option>
        </select><br><br>

        <label for="frequency">Frequency of requirements:</label>
        <select id="frequency" name="frequency" required>
            <option value="weekly">Weekly</option>
            <option value="monthly">Monthly</option>
            <option value="one-time">One-time requirement</option>
        </select><br><br>

        <label for="budget">Budget for one video (in USD):</label>
        <input type="text" id="budget" name="budget" required><br><br>

        <label for="specifications">Any other specifications:</label>
        <textarea id="specifications" name="specifications"></textarea><br><br>

        <label for="genre">Video genre:</label>
        <input type="text" id="genre" name="genre" required><br><br>

        <label for="afterEffects">After effect work requirements:</label>
        <input type="text" id="afterEffects" name="afterEffects" required><br><br>

        <label for="animationType">Animation (2D/3D):</label>
        <select id="animationType" name="animationType" required>
            <option value="2D">2D</option>
            <option value="3D">3D</option>
        </select><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
