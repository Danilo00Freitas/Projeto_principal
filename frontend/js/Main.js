// js/Main.js

import { login } from '/js/Auth.js';

document.addEventListener('DOMContentLoaded',() => {
    const loginForm = document.getElementById('loginForm');
    if(loginForm){
        loginForm.addEventListener('submit',async (event)=>{
            event.preventDefault();
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            try{
                const data = await login(email,password);
                console.log('Autenticado com sucesso:',data);
                //PODE SER QUE FUTURAMENTE EU TENHA MAIS AÇÕES DEPOIS DO LOGIN OCORRER COM SUCESSO...
            }catch(error){
                console.error('Erro ao autenticar...\n'+error)
                //pode ser que eu tenha outras tratativas no caso de erro futuramente.
                //No momento estou apenas mostrando uma mensagem de erro
            }
        })
    }
})