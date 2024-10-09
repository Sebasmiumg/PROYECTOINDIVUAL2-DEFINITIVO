import { useState, useEffect } from 'react';
import axios from 'axios';
import { Container, TextField, Button, Typography, Grid, Card, CardContent, IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';

function App() {
  const [notas, setNotas] = useState([]);
  const [nuevaNota, setNuevaNota] = useState({
    estudiante: '',
    actividades: '',
    primerParcial: '',
    segundoParcial: '',
    examenFinal: ''
  });

  useEffect(() => {
    obtenerNotas();
  }, []);

  const obtenerNotas = async () => {
    try {
      const respuesta = await axios.get('http://localhost:8080/api/notas');
      console.log('Datos recibidos desde el backend:', respuesta.data);
      setNotas(respuesta.data);
    } catch (error) {
      console.error('Error al obtener las notas:', error);
    }
  };

  const manejarCambio = (e) => {
    setNuevaNota({
      ...nuevaNota,
      [e.target.name]: e.target.value
    });
  };

  const registrarNota = async (e) => {
    e.preventDefault();
    console.log("Datos que se envían al backend:", nuevaNota);
    try {
      const respuesta = await axios.post('http://localhost:8080/api/notas', nuevaNota);
      setNotas([...notas, respuesta.data]);
      setNuevaNota({
        estudiante: '',
        actividades: '',
        primerParcial: '',
        segundoParcial: '',
        examenFinal: ''
      });
    } catch (error) {
      console.error('Error al registrar la nota:', error);
    }
  };

  const eliminarNota = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/notas/${id}`);
      setNotas(notas.filter((nota) => nota.id !== id)); 
      console.log(`Nota con ID: ${id} eliminada`);
    } catch (error) {
      console.error('Error al eliminar la nota:', error);
    }
  };

  return (
    <Container maxWidth="md">
      <Typography variant="h4" component="h1" gutterBottom align="center">
        Gestión de Notas
      </Typography>

      <form onSubmit={registrarNota} style={{ marginBottom: '20px' }}>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Estudiante"
              name="estudiante"
              value={nuevaNota.estudiante}
              onChange={manejarCambio}
              variant="outlined"
              required
            />
          </Grid>
          <Grid item xs={12} sm={6}>
            <TextField
              fullWidth
              label="Actividades"
              name="actividades"
              type="number"
              value={nuevaNota.actividades}
              onChange={manejarCambio}
              variant="outlined"
              required
            />
          </Grid>
          <Grid item xs={12} sm={6}>
            <TextField
              fullWidth
              label="Primer Parcial"
              name="primerParcial"
              type="number"
              value={nuevaNota.primerParcial}
              onChange={manejarCambio}
              variant="outlined"
              required
            />
          </Grid>
          <Grid item xs={12} sm={6}>
            <TextField
              fullWidth
              label="Segundo Parcial"
              name="segundoParcial"
              type="number"
              value={nuevaNota.segundoParcial}
              onChange={manejarCambio}
              variant="outlined"
              required
            />
          </Grid>
          <Grid item xs={12} sm={6}>
            <TextField
              fullWidth
              label="Examen Final"
              name="examenFinal"
              type="number"
              value={nuevaNota.examenFinal}
              onChange={manejarCambio}
              variant="outlined"
              required
            />
          </Grid>
          <Grid item xs={12}>
            <Button fullWidth variant="contained" color="primary" type="submit">
              Registrar Nota
            </Button>
          </Grid>
        </Grid>
      </form>

      <Typography variant="h5" component="h2" gutterBottom>
        Lista de Notas
      </Typography>
      <Grid container spacing={2}>
        {notas.length > 0 ? (
          notas.map((nota) => (
            <Grid item xs={12} sm={6} md={4} key={nota.id}>
              <Card>
                <CardContent>
                  <Typography variant="h6" component="h3">
                    ID: {nota.id} - {nota.estudiante}
                  </Typography>
                  <Typography variant="body1">Actividades: {nota.actividades}</Typography>
                  <Typography variant="body1">Primer Parcial: {nota.primerParcial}</Typography>
                  <Typography variant="body1">Segundo Parcial: {nota.segundoParcial}</Typography>
                  <Typography variant="body1">Examen Final: {nota.examenFinal}</Typography>
                  <Typography variant="h6" color="secondary">
                    Puntaje Total: {nota.puntajeTotal}
                  </Typography>
                  <IconButton onClick={() => eliminarNota(nota.id)} color="secondary">
                    <DeleteIcon />
                  </IconButton>
                </CardContent>
              </Card>
            </Grid>
          ))
        ) : (
          <Typography variant="body1" align="center" style={{ width: '100%' }}>
            No hay notas registradas.
          </Typography>
        )}
      </Grid>
    </Container>
  );
}

export default App;
