var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function (req, res, next) {
  // res.send('respond with a resource');
  res.render('users', { title: 'Express-Users' });
});

router.post('/', function(req, res, next){

});

module.exports = router;
