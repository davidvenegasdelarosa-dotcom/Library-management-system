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