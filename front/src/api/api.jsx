const API_URL = 'http://localhost:8080/api';

export const getOrdenes = async () => {
  const res = await fetch(`${API_URL}/ordenes`);
  if (!res.ok) throw new Error('Error al obtener órdenes');
  return res.json();
};

export const getCarritos = async () => {
  const res = await fetch(`${API_URL}/carritos`);
  return res.json();
};

export const getClientes = async () => {
  const res = await fetch(`${API_URL}/clientes`);
  return res.json();
};