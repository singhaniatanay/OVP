// Initialize express router
let router = require('express').Router();

// Set default API response
router.get('/', function (req, res) { 
    res.json({
       status: 'API Its Working',
       message: 'Welcome to EC-Voting crafted with love!',
    });
});

// Import leader controller
var leaderController = require('../controllers/leaderController');

// Leader routes
router.route('/leaders')
    .get(leaderController.index)
    .post(leaderController.new);

router.route('/leaders/:constituency')
    .get(leaderController.indexConstituency);

router.route('/leaders/:leader_id')
    .get(leaderController.view)
    .patch(leaderController.update)
    .put(leaderController.update)
    .delete(leaderController.delete);

// Import voting controller
var votingController = require('../controllers/votingController');

// Voting route
router.route('/vote/:partyName/:constituency')
    .put(votingController.submit);

// Export API routes
module.exports = router;