const apiUrl = 'http://localhost:8080/api/adventures';

// fetch and display adventures
async function fetchAdventures() {
    const response =  await fetch(apiUrl);
    const adventures = await response.json();
    const tbody = document.querySelector('#adventures tbody');
    tbody.innerHTML = '';
    adventures.forEach(adventure => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${adventure.id}</td>
            <td>${adventure.date}</td>
            <td>${adventure.country}</td>
            <td>${adventure.city}</td>
            <td>${adventure.state}</td>
            <td>${adventure.numPhotos}</td>
            <td>${adventure.blogCompleted}</td>
            <td>
                <button onclick="editAdventure(${adventure.id})">Edit</button>
                <button onclick="deleteAdventure(${adventure.id})">Delete</button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

// handle form submit
document.getElementById('adventureForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('adventureId').value;
    const adventure = {
        date: document.getElementById('date').value,
        country: document.getElementById('country').value,
        city: document.getElementById('city').value,
        state: document.getElementById('state').value,
        numPhotos: document.getElementById('numPhotos').value,
        blogCompleted: document.getElementById('blogCompleted').checked
    }

    if (id) {
        // update existing adventure
        await fetch(`${apiUrl}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(adventure),
        });
    } else {
        // create new adventure
        await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(adventure),
        });
    }

    fetchAdventures();
    document.getElementById('adventureForm').reset();
    document.getElementById('adventureId').value = '';
});

// edit adventure
async function editAdventure(id) {
    const response = await fetch(`${apiUrl}/${id}`);
    const adventure = await response.json();
    document.getElementById('adventureId').value = adventure.id;
    document.getElementById('date').value = adventure.date;
    document.getElementById('country').value = adventure.country;
    document.getElementById('city').value = adventure.city;
    document.getElementById('state').value = adventure.state;
    document.getElementById('numPhotos').value = adventure.numPhotos;
    document.getElementById('blogCompleted').checked = adventure.blogCompleted;
}

// delete adventure
async function deleteAdventure(id) {
    await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE',
    });
    fetchAdventures();
}

// initial fetch
fetchAdventures();
