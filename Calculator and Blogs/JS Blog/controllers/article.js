const Article = require('../models').Article;
const User = require('../models').User;

module.exports = {
    createGet: (req,res) => {
        res.render('article/create');
    },

    createPost: (req,res) => {
        let articleArgs = req.body;

        let errorMsg = '';

        if(!req.isAuthenticated()){
            errorMsg = 'Please,log in before writing an article!'
        } else if(!articleArgs.title){
            errorMsg = 'Invalid Title !';
        } else if(!articleArgs.content){
            errorMsg = 'Invalid content!';
        }

        if(errorMsg){
            res.render('article/create', {error:errorMsg})
            return;
        }
        articleArgs.authorId = req.user.id;

        Article.create(articleArgs).then(article =>{
            res.redirect('/');
        }).catch(err => {
            console.log(err);
            res.render('article/create', {error: err.message});
        })

    },

    details: (req,res) => {
        let id= req.params.id;
        Article.findById(id, {include: [
                {
                    model: User,
                }
            ]}).then(article => {
            res.render('article/details', article.dataValues)
        });

    }


};