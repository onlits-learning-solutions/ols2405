var fs = require('fs');
quote = 'With great power comes great responsibility';
fs.writeFile('quotes.txt', quote, function(err){
    if(err) throw err
});