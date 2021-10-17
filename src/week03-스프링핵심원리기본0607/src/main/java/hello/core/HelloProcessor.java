package hello.core;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCLiteral;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import hello.core.HelloWorld;

@SupportedAnnotationTypes({ "HelloWorld" })
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class HelloProcessor extends AbstractProcessor {

    @Override
    public boolean process(
            Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {

        if (roundEnv.processingOver()) {
            return false;
        }

        JavacProcessingEnvironment environment
                = (JavacProcessingEnvironment) processingEnv;

        Context context
                = environment.getContext();
        TreeMaker maker
                = TreeMaker.instance(context);
        JavacElements elemUtils
                = (JavacElements) processingEnv.getElementUtils();

        Class<HelloWorld> clazz = HelloWorld.class;
        Set<? extends Element> elements
                = roundEnv.getElementsAnnotatedWith(clazz);

        for (Element element : elements) {
            JCTree tree = elemUtils.getTree(element);
            JCTree.JCMethodDecl mDecl
                    = (JCTree.JCMethodDecl) tree;

            injectHelloWorld(maker, elemUtils, mDecl);
        }

        return false;
    }

    private void injectHelloWorld(
            TreeMaker maker,
            JavacElements elemUtils,
            JCTree.JCMethodDecl mDecl) {

        maker.pos = mDecl.pos;

        List<JCExpression> nil = List.<JCTree.JCExpression> nil();
        Name system = elemUtils.getName("System");
        Name out = elemUtils.getName("out");
        Name _println = elemUtils.getName("println");
        JCLiteral helloworld = maker.Literal("Hello world");

        mDecl.body = maker.Block(0,List.of(
                maker.Exec(maker.Apply(nil,
                        maker.Select(maker.Select(
                                maker.Ident(
                                        system),
                                out),
                                _println),
                        List.<JCTree.JCExpression> of(helloworld))),
                mDecl.body)
        );
    }
}