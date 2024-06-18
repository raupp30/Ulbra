const express = require('express');
const mongoose = require('mongoose');
const app = express();
const port = 3000;

mongoose.connect('mongodb+srv://admin:admin@teste.mwgstk5.mongodb.net/', {
useNewUrlParser: true,
useUnifiedTopology: true,
});

const Schema = mongoose.Schema;

const atletaSchema = new Schema({
nome: String,
idade: String,
esporte: String,
equipe: String,
});
const Atleta = mongoose.model('Atleta', atletaSchema);

app.use(express.json());

app.post('/atletas', async (req, res) => {
const newAtleta = new Atleta(req.body);
const savedAtleta = await newAtleta.save();
res.json(savedAtleta)
})

app.get('/atletas', async (req, res) => {
const atletas = await Atleta.find()
res.json(atletas)
})

app.get("/atletas/:id", async (req, res) => {
const atletas = await Atleta.findById(req.params.id)
res.json(atletas)
})

app.delete('/atletas/:id', async(req, res) => {
const atletaDeleted = await Atleta.findByIdAndDelete(req.params.id)
res.json(atletaDeleted)
})

app.put('/atletas/:id', async(req,res) => {
const atletas = await Atleta.findById(req.params.id)
atletas.nome = req.body.nome
atletas.idade = req.body.idade
atletas.esporte = req.body.esporte
atletas.equipe = req.body.equipe
const atletasUpdated = await atletas.save()
res.json(atletasUpdated)
})

app.listen(port, () => {
console.log(`Servidor está rodando em http://localhost:${port}`);
});