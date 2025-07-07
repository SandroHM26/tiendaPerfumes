import React, { useEffect, useState } from 'react';
import './App.css';

function App() {
  const [perfumes, setPerfumes] = useState([]);
  const [decantSeleccionado, setDecantSeleccionado] = useState(null);

  useEffect(() => {
    fetch(import.meta.env.VITE_API_URL + '/api/perfumes')
      .then(res => res.json())
      .then(data => setPerfumes(data))
      .catch(err => console.error('Error al obtener perfumes:', err));
  }, []);

  const handleDecantClick = (decant, perfumeNombre) => {
    setDecantSeleccionado({ ...decant, nombrePerfume: perfumeNombre });
  };

  return (
    <div className="app-container">
      <h1>Perfumes y Decants</h1>
      <div className="perfume-grid">
        {perfumes.map((perfume) => (
          <div key={perfume.id} className="perfume-card">
            <h2>{perfume.nombre}</h2>
            <p>{perfume.descripcion}</p>
            <h3>Decants:</h3>
            <ul>
              {perfume.decants.map((decant) => (
                <li
                  key={decant.id}
                  className="decant-item"
                  onClick={() => handleDecantClick(decant, perfume.nombre)}
                >
                  {perfume.nombre} - {decant.volumenMl}ml
                </li>
              ))}
            </ul>
          </div>
        ))}
      </div>

      {decantSeleccionado && (
        <div className="modal-overlay" onClick={() => setDecantSeleccionado(null)}>
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <h2>{decantSeleccionado.nombrePerfume} - {decantSeleccionado.volumenMl}ml</h2>
            <p><strong>Volumen:</strong> {decantSeleccionado.volumenMl} ml</p>
            <p><strong>Stock:</strong> {decantSeleccionado.stock}</p>
            <p><strong>Precio:</strong> S/. {decantSeleccionado.precio}</p>
            <button onClick={() => setDecantSeleccionado(null)}>Cerrar</button>
          </div>
        </div>
      )}
    </div>
  );
}

export default App;
