package com.lyb.besttimer.lib_compiler;

import com.google.auto.service.AutoService;
import com.lyb.besttimer.annotation_api.BindClassCenter;
import com.lyb.besttimer.lib_annotation.BindClass;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.WildcardTypeName;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
public class BindClassProcessor extends AbstractProcessor {

    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        String packageName = "com.lyb.besttimer.processor";
        String simpleName = "BindClassInit";

        TypeSpec.Builder builder = TypeSpec.classBuilder(simpleName)
                .addModifiers(Modifier.PUBLIC);

        ClassName selfClassName = ClassName.get(packageName, simpleName);
        ClassName mapClassName = ClassName.get("java.util", "Map");
        ClassName hashmapClassName = ClassName.get("java.util", "HashMap");
        ClassName stringClassName = ClassName.get("java.lang", "String");
        ClassName classClassName = ClassName.get("java.lang", "Class");
        ParameterizedTypeName classVoidTypeName = ParameterizedTypeName.get(classClassName, WildcardTypeName.subtypeOf(TypeName.OBJECT));
        ParameterizedTypeName mapSCTypeName = ParameterizedTypeName.get(mapClassName, stringClassName, classVoidTypeName);

        FieldSpec.Builder singleSpecBuilder = FieldSpec.builder(selfClassName, "singleInstance", Modifier.PRIVATE, Modifier.STATIC);
        singleSpecBuilder.initializer(CodeBlock.of("new $T()", selfClassName));
        builder.addField(singleSpecBuilder.build());

        MethodSpec.Builder singleMethodSpecBuilder = MethodSpec
                .methodBuilder("getInstance")
                .returns(selfClassName)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addStatement("return $N", "singleInstance");
        builder.addMethod(singleMethodSpecBuilder.build());

        FieldSpec.Builder fieldSpecBuilder = FieldSpec.builder(mapSCTypeName, "bindMap", Modifier.PRIVATE);
        fieldSpecBuilder.initializer(CodeBlock.of("new $T<>()", hashmapClassName));
        builder.addField(fieldSpecBuilder.build());

        MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE);
        Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(BindClass.class);
        for (Element element : elementSet) {
            if (element.getKind() == ElementKind.CLASS) {
                TypeElement typeElement = (TypeElement) element;
                BindClass bindClass = typeElement.getAnnotation(BindClass.class);
                constructorBuilder.addStatement("bindMap.put($S,$T.class)", bindClass.path(), ClassName.get(typeElement));
            }
        }
        builder.addMethod(constructorBuilder.build());

        ClassName center = ClassName.get(BindClassCenter.class);
        MethodSpec.Builder findMethodSpecBuilder = MethodSpec
                .methodBuilder("init")
                .returns(TypeName.VOID)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$T.bindMap=this.$N", center, "bindMap");
        builder.addMethod(findMethodSpecBuilder.build());

        try {
            JavaFile.builder(packageName, builder.build()).build().writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(BindClass.class.getCanonicalName());
        return types;
    }
}
