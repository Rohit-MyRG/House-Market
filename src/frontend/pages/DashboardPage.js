import { getProperties } from "../services/propertyService.js";

async function loadProperties() {
    const properties = await getProperties();
    const propertyList = document.getElementById("property-list");

    propertyList.innerHTML = ""; // Clear existing property listing
    properties.forEach((property) => {
        const item = document.createElement("div");
        item.classList.add("property-item");

        // Creating property card
        item.innerHTML = `
            <h3>${property.title}</h3>
            <p><strong>Description:</strong> ${property.description}</p>
            <p><strong>Location:</strong> ${property.location}</p>
            <p><strong>Price:</strong> ₹${property.price}</p>
            <p><strong>Availability:</strong> ${
                property.availability ? "Available" : "Unavailable"
            }</p>
            <p><strong>Owner:</strong> ${property.owner.name}</p>
        `;

        propertyList.appendChild(item);
    });
}

// Search functionality
function searchProperties() {
    const searchInput = document
        .getElementById("search-bar")
        .value.toLowerCase();
    const propertyItems = document.querySelectorAll(".property-item");

    propertyItems.forEach((item) => {
        const title = item.querySelector("h3").textContent.toLowerCase();
        item.style.display = title.includes(searchInput) ? "" : "none";
    });
}

// Event listener for search
document
    .getElementById("search-bar")
    .addEventListener("input", searchProperties);

document.addEventListener("DOMContentLoaded", loadProperties);
