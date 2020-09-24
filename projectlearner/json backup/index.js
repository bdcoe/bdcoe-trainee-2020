const readline = require('readline');
const { google } = require('googleapis');
const SCOPES = ['https://www.googleapis.com/auth/drive', 'https://www.googleapis.com/auth/drive.readonly', 'https://www.googleapis.com/auth/drive.metadata.readonly'];
const TOKEN_PATH = 'token.json';
const fs = require('fs');
const express = require('express');
const app = express();
const bodyParser = require('body-parser');


app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json({ limit: '50mb', type: 'application/json' }))

app.use('/upload', (req, res) => {
    function authorize(credentials, callback) {
        const { client_secret, client_id, redirect_uris } = credentials.installed;
        const oAuth2Client = new google.auth.OAuth2(
            client_id, client_secret, redirect_uris[0]);
        // Check if we have previously stored a token.
        fs.readFile(TOKEN_PATH, (err, token) => {
            if (err) return getAccessToken(oAuth2Client, callback);
            oAuth2Client.setCredentials(JSON.parse(token));
            callback(oAuth2Client);
        });
    };
    function getAccessToken(oAuth2Client, callback) {
        const authUrl = oAuth2Client.generateAuthUrl({
            access_type: 'offline',
            scope: SCOPES,
        });
        console.log('Authorize this app by visiting this url:', authUrl);
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout,
        });
        rl.question('Enter the code from that page here: ', (code) => {
            rl.close();
            oAuth2Client.getToken(code, (err, token) => {
                if (err) return { 'err': `${err}` }//console.error('Error retrieving access token', err);
                oAuth2Client.setCredentials(token);
                // Store the token to disk for later program executions
                fs.writeFile(TOKEN_PATH, JSON.stringify(token), (err) => {
                    if (err) return console.error(err);
                    console.log('Token stored to', TOKEN_PATH);
                });
                callback(oAuth2Client);
            });
        });
    }

    var upload = async () => {
        function uploadFile(auth) {
            const drive = google.drive('v3');
            var d = new Date;
            console.log('upload called')
            const fileMetadata = {
                'name': `Backup_${d.toISOString()}.json`,
                parents: ['1AQBq1LThSpgkCkVIfz2WHbxfFPS-mooP']
            }

            const media = {
                mimeType: 'application/json',
                body: fs.createReadStream('/tmp/final.json')
            }
            drive.files.create({
                auth: auth,
                resource: fileMetadata,
                media: media
            }, err => {
                if (err) { return res.json({ 'res': `${err}` }) }
            })
        }
        fs.readFile('./credentials.json', (err, content) => {
            if (err) return console.log('Error loading client secret file:', err);
            // Authorize a client with credentials, then call the Google Drive API.
            authorize(JSON.parse(content), uploadFile)
        })
    }
    var sam = async () => {
        console.log(req.body, JSON.stringify(req.body))
        let wstream = fs.createWriteStream('/tmp/final.json')
        wstream.write(JSON.stringify(req.body), (err) => {
            if (err) res.json({ "res": err })
            else (upload()
            ).then(event => {
                res.json({ "res": "done" })
            })

                .catch(err => {
                    res.json({ "res": err })
                })
        })
    }
    sam();
}
)
const PORT = process.env.PORT || 5000;


app.listen(PORT);






