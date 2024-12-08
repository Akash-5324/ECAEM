<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@400..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="home.css">
</head>

<body>
    <!-- Navbar Section -->
    <nav class="navbar">
        <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li><a href="#contact">Contact Us</a></li>
            <li><a href="#profile">Profiles</a></li>
            <div class="login-form">
    			<a href="clublogin">Head Login</a>
    			<a href="studentlogin">User Login</a>
			</div>


        </ul>

       
    </nav>

    <!-- GUCCI Brand Name Section -->
    <div id="brand" class="brand-name">ECAEM</div>

    <!-- Main Content Section -->
    
        <div class="hero">
            <div class="overlay">
                <h2>Project Developers</h2>
                

                <form action="#profile" class="inline">
                    <button class="float-left submit-button" >EXPLORE THERE DETAILS</button>
                </form>
            </div>
        </div>

    

    <!-- Contact Us Section -->
    <section id="contact" class="contact-section">
        <h2>Contact Us</h2>
        <p>If you have any questions, feel free to reach out to us!</p>
        <form class="contact-form">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="message">Message:</label>
            <textarea id="message" name="message" rows="5" required></textarea>

            <button type="submit">Send Message</button>
            <br>
            <br>
            <br>
        </form>
    </section>

<!------------------------------------------------------------team members---------------------------------------------------------->


<div class="team-container" id="profile">
    <header>
        <h1>OUR TEAM</h1>
        <p>LET'S WORK TOGETHER</p>
    </header>
    <main class="team-members">
        <div class="member">
            <div class="member-image">
                <img src="https://i.ibb.co/ysHv4yX/photo-2024-11-06-23-30-25.jpg" alt="Akash" />
            </div>
            <h2>Akash</h2>
            <p class="role">Director</p>
            <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <div class="social-links">
                <a href="#" aria-label="Facebook profile"><i class="fab fa-facebook"></i></a>
                <a href="#" aria-label="Twitter profile"><i class="fab fa-twitter"></i></a>
            </div>
        </div>
        <div class="member">
            <div class="member-image">
                <img src="https://i.ibb.co/X35Y8Qw/photo-2024-11-06-23-33-42.jpg" alt="Aarya" />
            </div>
            <h2>Aarya</h2>
            <p class="role">Director</p>
            <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <div class="social-links">
                <a href="#" aria-label="Facebook profile"><i class="fab fa-facebook"></i></a>
                <a href="#" aria-label="Twitter profile"><i class="fab fa-twitter"></i></a>
            </div>
        </div>
        <div class="member">
            <div class="member-image">
                <img src="https://i.ibb.co/qytQK2S/Whats-App-Image-2024-11-06-at-23-05-51-c08316b0.jpg" alt="Vignesh" />
            </div>
            <h2>Vignesh</h2>
            <p class="role">Director</p>
            <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <div class="social-links">
                <a href="#" aria-label="Facebook profile"><i class="fab fa-facebook"></i></a>
                <a href="#" aria-label="Twitter profile"><i class="fab fa-twitter"></i></a>
            </div>
            
        </div>
    </main>
    
    
    <footer>
        <p>YOUR COMPANY</p>
    </footer>
    
</div>
<div class="ripple-background"></div>


    <!-- Link to JavaScript -->
    <script src="home.js"></script>
</body>

</html>