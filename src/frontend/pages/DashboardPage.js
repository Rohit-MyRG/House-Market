import { getProperties } from "../services/propertyService.js";

async function loadProperties() {
    const properties = await getProperties();
    const propertyList = document.getElementById("property-list");

    properties.forEach((property) => {
        const item = document.createElement("div");
        item.classList.add("property-item");
        item.textContent = property.name;
        propertyList.appendChild(item);
    });
}

document.addEventListener("DOMContentLoaded", loadProperties);
