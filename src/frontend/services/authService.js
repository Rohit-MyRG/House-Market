export async function authenticateUser(email, password) {
    try {
        const response = await fetch("http://localhost:8080/api/authenticate", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ email, password }),
        });

        if (!response.ok) {
            throw new Error("Failed to authenticate");
        }

        const data = await response.json();
        return {
            success: true,
            accessToken: data.jwtToken,
            refreshToken: data.refreshToken,
        };
    } catch (error) {
        console.error("Authentication error:", error);
        return { success: false };
    }
}
