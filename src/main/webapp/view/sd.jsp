<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>YouTube-like Video Player</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .video-container {
            position: relative;
            padding-bottom: 56.25%; /* 16:9 aspect ratio (change as needed) */
            height: 0;
        }

        .video {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }

        .video-title {
            font-size: 24px;
            font-weight: bold;
            margin-top: 20px;
            margin-bottom: 10px;
        }

        .video-description {
            font-size: 16px;
            color: #555;
        }
    </style>
</head>
<body>
    <div class="video-container">
        <video controls class="video">
            <source src="/video/${videoLink}" type="video/mp4">
        </video>
    </div>
    
    <div class="video-title">${title}</div>
    
    <div class="video-description">
       
    </div>
</body>
</html>
