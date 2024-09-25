export function getAccessToken() {
    return localStorage.getItem("accessToken");
}

export function getRefreshToken() {
    return localStorage.getItem("refreshToken");
}

export async function refreshToken() {
    const refreshToken = getRefreshToken();
    if (!refreshToken) return;

    const response = await fetch(
        "http://localhost:8080/api/authenticate/refresh",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ refreshToken }),
        }
    );

    if (response.ok) {
        const data = await response.json();
        localStorage.setItem("accessToken", data.accessToken);
        return data.accessToken;
    }

    return null;
}
