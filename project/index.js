const express = require('express');
const bodyParser = require('body-parser');
const pdf = require('html-pdf');
const cors = require('cors');
const path = require('path');

const pdfTemplate = require('./documents');

const app = express();

const port = process.env.PORT || 5000;


app.use(cors());
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

// POST Route - PDF generation and fetching of the data

app.post('/create-pdf', (req, res) => {
    console.log("In create pdf");
    pdf.create(pdfTemplate(req.body), {}).toFile('Resume.pdf', (err) => {
        if(err){
            res.send(Promise.reject());
            console.log(err);
        }

        res.send(Promise.resolve());
        console.log('Success');
    });
});


// Get - Send generated pdf to the client
app.get('/fetch-pdf', (req,res) => {
    console.log('sdfsdf');
    res.sendFile(`${__dirname}/Resume.pdf`);
});

// Serve static assets if in production
if(process.env.NODE_ENV === 'production'){
    //set static folder
    app.use(express.static('client/build'));

    app.get('*', (req, res) => {
        res.sendFile(path.resolve(__dirname, 'client', 'build', 'index.html'));
    });
}


app.listen(port, () => console.log(`Server started on port ${port}`));


