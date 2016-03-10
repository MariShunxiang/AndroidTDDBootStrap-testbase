android_build_config(
	name = 'build_config',
	package = 'com.github.piasy.base.test',
	values = [
		'String VERSION_NAME = "1.0.0"',
		'String BUILD_TYPE = "release"',
		'int VERSION_CODE = 1',
		'String FLAVOR = "default"',
	],
	visibility = [
		'PUBLIC',
	],
)

android_library(
	name = 'src',
	srcs = glob([
		'src/main/java/**/*.java',
	]),
	manifest = 'src/main/AndroidManifest.xml',
	annotation_processors = [
	],
	annotation_processor_deps = [
	],
	deps = [
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:jar__okio-1.6.0.jar',
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:jar__javax.inject-1.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__hamcrest-library-1.4-atlassian-1.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:aar__espresso-contrib-2.2.1.aar',
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:jar__threetenbp-1.3.1-no-tzdb.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__accessibility-test-framework-2.0.jar',
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:aar__threetenabp-1.0.3.aar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__hamcrest-integration-1.3.jar',
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:jar__okhttp-3.2.0.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:aar__espresso-intents-2.2.1.aar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__junit-4.12.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:aar__espresso-idling-resource-2.2.1.aar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__bcprov-jdk15on-1.50.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:aar__espresso-core-2.2.1.aar',
		'//.okbuck/4DE15632C1100FEAC1365DFB6EAFA611:jar__jsr305-2.0.1.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__mockwebserver-3.2.0.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__javawriter-2.1.1.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__okhttp-ws-3.2.0.jar',
		'//.okbuck/2642B707F0A5437CDBDFA4D1271EC7BE:jar__hamcrest-core-1.4-atlassian-1.jar',
		':build_config',
	],
	visibility = [
		'PUBLIC',
	],
)

project_config(
	src_target = '//testbase:src',
	src_roots = [
		'src/main/java',
	],
)

