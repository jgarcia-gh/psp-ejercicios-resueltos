function esperar(ms){
    return new Promise((resolve, reject) =>{
        setTimeout(resolve,ms);
    });
}

async function procesarTarea() {
    console.log("Iniciando tarea")
    await esperar(2000);
    return "Tarea completada";
}

procesarTarea().then((msg) => console.log(msg));
