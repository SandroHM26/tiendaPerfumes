import { useEffect, useState } from 'react';
import { getOrdenes } from '../api/api';

export default function OrdenList() {
  const [ordenes, setOrdenes] = useState([]);

  useEffect(() => {
    getOrdenes().then(setOrdenes).catch(console.error);
  }, []);

  return (
    <div>
      <h2>Órdenes registradas</h2>
      <ul>
        {ordenes.map((orden) => (
          <li key={orden.id}>
            Orden #{orden.id} - Total: S/ {orden.total} - Estado: {orden.estado}
          </li>
        ))}
      </ul>
    </div>
  );
}
