package com.xiongping.utiltest;


import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class UtilTest {

	public static void main(String[] args) throws IOException {
		final SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();
		final MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader(Company.class.getName());
		final ClassMetadata classMetadata = metadataReader.getClassMetadata();
		final String[] memberClassNames = classMetadata.getMemberClassNames();
		System.out.println(memberClassNames[0]);
		final AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		final MergedAnnotations annotations = annotationMetadata.getAnnotations();
		final MergedAnnotation<Component> componentMergedAnnotation = annotations.get(Component.class);

	}
}
