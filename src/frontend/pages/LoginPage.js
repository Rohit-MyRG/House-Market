import { authenticateUser } from "../services/authService.js";
import LoginFormHTML from "../components/Login.js";

export default function LoginPage() {
    document.getElementById("root").innerHTML = LoginFormHTML;

    document
        .getElementById("login-form")
        .addEventListener("submit", async function (e) {
            e.preventDefault();

            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            const response = await authenticateUser(email, password);

            if (response.success) {
                // Store tokens (access & refresh) in localStorage as of now
                localStorage.setItem("accessToken", response.accessToken);
                localStorage.setItem("refreshToken", response.refreshToken);

                // Redirect to dashboard
                alert("Login success!");
                window.location.href = "../frontend/dashboard.html";
            } else {
                document.getElementById("error-message").textContent =
                    "Invalid credentials!";
            }
        });
}
