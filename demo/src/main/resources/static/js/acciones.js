//No podemos dejar que js cargue antes que html, tiene que cargar a la vez o más tarde, asi que lo hacemos esperar
document.addEventListener("DOMContentLoaded", () => {console.log("¡Conexión establecida con el Frontend")

    //Resaltamos las líneas cuando hacemos clic en ella
    const filas = document.querySelectorAll("tbody tr");
    filas.forEach(fila => {
       fila.addEventListener("click", () => {
           filas.forEach(f => f.style.backgroundColor= "");
          fila.style.backgroundColor = "#d1e7ff";
      });
    });
});
function borrarConJS(boton){
    const id=boton.getAttribute('data-id');
    fetch('/libros/delete/' + id, {method: 'DELETE'})
    .then(response => {
        if(response.status==200){
            document.getElementById('fila-'+id).remove();
            console.log("Borrado correctamente");
        } else if(response.status==404){
            alert("Pae+rece que ese libro no existe");
            location.reload();//Recargamos para refrescar la lista
        } else if(response.status==500){
            alert("Hubo un error en el servidor");
        }
    })
}

function añadirConJS(){
    const titulo= document.getElementById('nuevo-titulo').value;
    const autor= document.getElementById('nuevo-autor').value;
    
    fetch(`/libros/add?titulo=${titulo}&autor=${autor}`, {method:'POST'})
    .then(response => {
        if(response.ok){
            return response.json(); //Esperamos a que java nos devuelva el libro guardado ya con el id creado
        } else if(response.status===409){
            throw  new Error("El libro ya existe"); //Saltamos al .catch
        } else {
            throw new Error("Error desconocido en el servidor"); //Saltamos al .catch
        }
    })
    .then(libroGuardado => {
        //Añadimos la fila a la tabla dinámicamente
        const tabla = document.querySelector("table tbody");
        const nuevaFila = `
        <tr id="fila-${libroGuardado.id}">
            <td>${libroGuardado.id}</td>
            <td>${libroGuardado.titulo}</td>
            <td>${libroGuardado.autor}</td>
            <td>
                <button type="button" data-id="${libroGuardado.id}" onclick="borrarConJS(this)"
                style="background-color:#ff4d4d; color:white;border:none;padding:5px 10px;cursor:pointer;border-radius:4px">
                Eliminar
                </button>
            </td>
        </tr>`
        tabla.innerHTML+=nuevaFila;
        //Limpiamos los buffers
        document.getElementById('nuevo-titulo').value='';
        document.getElementById('nuevo-autor').value='';
    })
    .catch(error=>{
        alert(error.message);
    });

}