<?php

namespace SoftUniBlogBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Bundle\FrameworkBundle\Tests\Fixtures\Validation\Article;

class HomeController extends Controller
{
    /**
     * @Route("/", name="blog_index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function indexAction()
    {
        $articles = $this->getDoctrine() -> getRepository(\SoftUniBlogBundle\Entity\Article::class)->findAll();

        return $this->render('blog/index.html.twig',['articles'=> $articles]);
    }
}
