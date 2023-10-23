<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Video Thumbnails</title>
    <style>
        /* Define a fixed image size for the video thumbnails */
        .video-thumbnail {
            width: 300px; /* Adjust the width as needed */
            height: 200px; /* Adjust the height as needed */
        }

        /* Customize card styling to look like YouTube cards */
        .custom-card {
            border: none; /* Remove default border */
            background-color: #fff; /* Background color for the card */
            border-radius: 8px; /* Slightly rounded corners for the card */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
            transition: transform 0.2s ease-in-out; /* Add a smooth transition effect for hover */
        }

        /* Style the card title */
        .card-title {
            font-size: 1rem; /* Adjust font size */
            margin-top: 10px; /* Adjust margin-top as needed */
            font-weight: bold;
        }

        /* Style the card subtitle */
        .card-subtitle {
            font-size: 0.9rem; /* Adjust font size */
            color: #606060; /* Adjust text color */
        }

        /* Add hover effect to the card */
        .custom-card:hover {
            transform: scale(1.05); /* Scale the card slightly on hover */
         
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <c:forEach items="${obj}" var="candidate">
                <div class="col-md-4 mb-4">
                    <div class="card custom-card">
                        <a href="sd/${candidate.getVideos()}">
                            <!-- Use the video thumbnail image as a link -->
                            <img src="images/${candidate.getThumbnails()}" class="card-img-top video-thumbnail" alt="Thumbnail">
                        </a>
                        <div class="card-body">
                            <h5 class="card-title">${candidate.getName()}</h5>
                            <!-- Add a subtitle for additional information if needed -->
                            <!-- <p class="card-subtitle">Subtitle Here</p> -->
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


    <!-- Add Bootstrap JS Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-q8i/X+965DzO10PzLYPjz6vB/P5fB4c2f5xm59s5TJAgOGgK5f3F5dzdE0bHSO6V9B" crossorigin="anonymous"></script>
</body>
</html>
