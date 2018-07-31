let Calculator = require('../models/Calculator');
module.exports = {
    indexGet: (req, res) => {
        res.render('home/index');
    },

    indexPost: (req,res) =>{
        let body =req.body;
        let leftOperand = body.calculator.leftOperand;
        let operator = body.calculator.operator;
        let rightOperand = body.calculator.rightOperand;

        let calculator= new Calculator();

        calculator.leftOperand=Number(leftOperand);
        calculator.operator=operator;
        calculator.rightOperand=Number(rightOperand);

        let result = calculator.calculateResult();

        res.render("home/index",{'calculator': calculator,'result': result})
    }
};