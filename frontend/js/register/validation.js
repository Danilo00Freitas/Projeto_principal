export function validateEmailField(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

export function validatePasswordField(password) {
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*\W).{8,}$/;
    return passwordRegex.test(password);
}

export function validatePhoneField(phone) {
    const phoneRegex = /^\d{11}$/;
    return phoneRegex.test(phone);
}

export function validateZipField(zip) {
    const zipRegex = /^\d{8}$/;
    return zipRegex.test(zip);
}

export function validateAddressNumberField(number) {
    const numberRegex = /^\d+$/;
    return numberRegex.test(number);
}

export function validateFields(email, password, cep, phone,number) {
    let errorList = [];

    if (!validateEmailField(email)) {
        errorList.push('Email inválido!');
    }

    if (!validatePasswordField(password)) {
        errorList.push('Senha inválida!');
    }

    if (!validatePhoneField(phone)) {
        errorList.push('Telefone inválido!');
    }

    if (!validateZipField(cep)) {
        errorList.push('CEP inválido!');
    }

    if (!validateAddressNumberField(number)) {
        errorList.push('Número do endereço inválido!');
    }
    return errorList;
}

