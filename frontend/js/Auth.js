// js/Auth.js

export async function login(email, password) {
    const requestBody = { email, password };
    console.log('Request body:', requestBody);

    try {
        const response = await fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody),
            credentials: 'include' // Inclui cookies e credenciais na solicitação
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        if (data.token) {
            sessionStorage.setItem('token', data.token); // Armazena o token no localStorage
            sessionStorage.setItem('userName', data.name);
        }
        return data;
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}
