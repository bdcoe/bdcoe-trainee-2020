const mongoose = require('mongoose');

const SolutionSchema = mongoose.Schema({
    solapp: {
        type: String,
        required: false
    },
    sol: {
        type: String,
        required: false
    },
    Qid: {
        type: String,
        required: false
    },
    owner: {
        type: String,
        required: false
    },
    like: {
        type: [String],
        required: false
    },
    dislike: {
        type: [String],
        required: false
    }
})

const SolutionModel = mongoose.model('solution', SolutionSchema);
module.exports = SolutionModel;
