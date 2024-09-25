import { getAccessToken, refreshToken } from "../utils/tokenManager.js";

async function apiRequest(url, options = {}) {
    let token = getAccessToken();

    const response = await fetch(url, {
        method: "GET",
        headers: {
            Authorization: `Bearer ${token}`,
        },
    });

    if (response.status === 401) {
        // Token expired
        token = await refreshToken(); // Get a new token
        if (token) {
            // Retry request with new token
            return fetch(url, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
        }
    }

    return response;
}

export async function getProperties() {
    const response = await apiRequest("http://localhost:8080/api/properties");
    return response.json();
}
