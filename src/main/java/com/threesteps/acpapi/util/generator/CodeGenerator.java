package com.threesteps.acpapi.util.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    public static final String GROUP_NAME = "threesteps";
    public static final String PROJECT_NAME = "acpapi";
    public static final String BASE_PATH = "./src/main/java/com/" + GROUP_NAME + "/" + PROJECT_NAME;
    public static final String BASE_PACKAGE = "com." + GROUP_NAME + "." + PROJECT_NAME + ".";
    public static final String ENTITY_CLASS_NAME_PASCAL_CASE = "Vacancy";
    public static final String TABLE_NAME = "vacancies";
    public static final String API_ROUTE = "vacancies";


    public static void main(String[] args) throws IOException {
        createEntity();
        createDto();
        createRequestDto();
        createRepository();
        createMapper();
        createService();
        createController();
    }

    public static void createEntity() throws IOException {
        File file = new File(BASE_PATH + "/model/" + ENTITY_CLASS_NAME_PASCAL_CASE + ".kt");
        if (file.exists()) return;
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("package " + BASE_PACKAGE + "model");
        runNewLine(2, writer);
        writer.write("import jakarta.persistence.*");
        runNewLine(1, writer);
        writer.write("import org.hibernate.annotations.GenericGenerator");
        runNewLine(2, writer);
        writer.write("@Entity");
        runNewLine(1, writer);
        writer.write("@Table(name = \"" + TABLE_NAME + "\")");
        runNewLine(1, writer);
        writer.write("data class " + ENTITY_CLASS_NAME_PASCAL_CASE + " @JvmOverloads constructor(");
        runNewLine(2, writer);
        writer.write("    @Id");
        runNewLine(1, writer);
        writer.write("    @GeneratedValue(generator = \"UUID\")");
        runNewLine(1, writer);
        writer.write("    @GenericGenerator(name = \"UUID\", strategy = \"org.hibernate.id.UUIDGenerator\")");
        runNewLine(1, writer);
        writer.write("    var id: String? = null,\n" +
                "\n" +
                "    var title: String? = null");
        runNewLine(2, writer);
        writer.write(") {");
        runNewLine(1, writer);
        writer.write("}");
        writer.close();
    }

    public static void createDto() throws IOException {
        File file = new File(BASE_PATH + "/dto/" + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto.kt");
        if (file.exists()) return;
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("package " + BASE_PACKAGE + "dto");
        runNewLine(2, writer);
        writer.write("data class " + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto @JvmOverloads constructor(");
        runNewLine(2, writer);
        writer.write("    var id: String? = null,\n" +
                "    var title: String? = null\n");
        runNewLine(1, writer);
        writer.write(") {");
        runNewLine(1, writer);
        writer.write("}");
        writer.close();
    }

    public static void createRequestDto() throws IOException {
        File file = new File(BASE_PATH + "/dto/Create" + ENTITY_CLASS_NAME_PASCAL_CASE + "Request.kt");
        if (file.exists()) return;
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("package " + BASE_PACKAGE + "dto");
        runNewLine(2, writer);
        writer.write("data class Create" + ENTITY_CLASS_NAME_PASCAL_CASE + "Request @JvmOverloads constructor(");
        runNewLine(2, writer);
        writer.write("    var title: String? = null");
        runNewLine(2, writer);
        writer.write(") {");
        runNewLine(1, writer);
        writer.write("}");
        writer.close();
    }

    public static void createRepository() throws IOException {
        File file = new File(BASE_PATH + "/repository/" + ENTITY_CLASS_NAME_PASCAL_CASE + "Repository.java");
        if (file.exists()) return;
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("package " + BASE_PACKAGE + "repository;");
        runNewLine(2, writer);
        writer.write("import " + BASE_PACKAGE + "model." + ENTITY_CLASS_NAME_PASCAL_CASE + ";");
        runNewLine(1, writer);
        writer.write("import org.springframework.data.jpa.repository.JpaRepository;");
        runNewLine(2, writer);

        writer.write("public interface " + ENTITY_CLASS_NAME_PASCAL_CASE + "Repository extends JpaRepository<" + ENTITY_CLASS_NAME_PASCAL_CASE + ", String> {");
        runNewLine(1, writer);
        writer.write("}");
        writer.close();
    }

    public static void createMapper() throws IOException {
        File file = new File(BASE_PATH + "/mapper/" + ENTITY_CLASS_NAME_PASCAL_CASE + "Mapper.java");
        if (file.exists()) return;
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("package " + BASE_PACKAGE + "mapper;");
        runNewLine(2, writer);
        writer.write("import " + BASE_PACKAGE + "dto." + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto;");
        runNewLine(1, writer);
        writer.write("import " + BASE_PACKAGE + "dto.Create" + ENTITY_CLASS_NAME_PASCAL_CASE + "Request;");
        runNewLine(1, writer);
        writer.write("import " + BASE_PACKAGE + "model." + ENTITY_CLASS_NAME_PASCAL_CASE + ";");
        runNewLine(1, writer);
        writer.write("import org.springframework.stereotype.Component;");
        runNewLine(2, writer);
        writer.write("@Component");
        runNewLine(1, writer);
        writer.write("public class " + ENTITY_CLASS_NAME_PASCAL_CASE + "Mapper {");
        runNewLine(2, writer);
        writer.write("    public " + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto toDTO(" + ENTITY_CLASS_NAME_PASCAL_CASE + " from) {\n" +
                "        if (from == null) return null;\n\n" +
                "        return new " + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto(from.getId(), from.getTitle());\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    public " + ENTITY_CLASS_NAME_PASCAL_CASE + " toDBO(Create" + ENTITY_CLASS_NAME_PASCAL_CASE + "Request from) {\n" +
                "        if (from == null) return null;\n\n" +
                "        return new " + ENTITY_CLASS_NAME_PASCAL_CASE + "(null, from.getTitle());\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    public " + ENTITY_CLASS_NAME_PASCAL_CASE + " toDBO(" + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto from) {\n" +
                "        if (from == null) return null;\n\n" +
                "        return new " + ENTITY_CLASS_NAME_PASCAL_CASE + "(from.getId(), from.getTitle());\n" +
                "    }");

        runNewLine(2, writer);

        writer.write("}");
        writer.close();
    }

    public static void createService() throws IOException {
        File file = new File(BASE_PATH + "/service/" + ENTITY_CLASS_NAME_PASCAL_CASE + "Service.java");
        if (file.exists()) return;
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("package " + BASE_PACKAGE + "service;");
        runNewLine(2, writer);
        writer.write("import " + BASE_PACKAGE + "dto." + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto;\n" +
                "import " + BASE_PACKAGE + "dto.Create" + ENTITY_CLASS_NAME_PASCAL_CASE + "Request;\n" +
                "import " + BASE_PACKAGE + "exception.NotFoundException;\n" +
                "import " + BASE_PACKAGE + "mapper." + ENTITY_CLASS_NAME_PASCAL_CASE + "Mapper;\n" +
                "import " + BASE_PACKAGE + "model." + ENTITY_CLASS_NAME_PASCAL_CASE + ";\n" +
                "import " + BASE_PACKAGE + "repository." + ENTITY_CLASS_NAME_PASCAL_CASE + "Repository;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "\n" +
                "import java.util.List;");

        runNewLine(2, writer);
        writer.write("@Service");
        runNewLine(1, writer);
        writer.write("public class " + ENTITY_CLASS_NAME_PASCAL_CASE + "Service {");
        runNewLine(2, writer);
        writer.write("    private final " + ENTITY_CLASS_NAME_PASCAL_CASE + "Repository repository;\n" +
                "    private final " + ENTITY_CLASS_NAME_PASCAL_CASE + "Mapper " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper;\n" +
                "\n" +
                "    public " + ENTITY_CLASS_NAME_PASCAL_CASE + "Service(" + ENTITY_CLASS_NAME_PASCAL_CASE + "Repository repository, " + ENTITY_CLASS_NAME_PASCAL_CASE + "Mapper " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper) {\n" +
                "        this.repository = repository;\n" +
                "        this." + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper = " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper;\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    public List<" + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto> getAll() {\n" +
                "        return repository.findAll()\n" +
                "                .stream()\n" +
                "                .map(" + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper::toDTO)\n" +
                "                .toList();\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    public " + ENTITY_CLASS_NAME_PASCAL_CASE + " findById(String id) {\n" +
                "        return repository.findById(id)\n" +
                "                .orElseThrow(() -> new NotFoundException(\"Couldn't find " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + " with id: \" + id));\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    public " + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto getById(String id) {\n" +
                "        return " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper.toDTO(findById(id));\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    public void add(Create" + ENTITY_CLASS_NAME_PASCAL_CASE + "Request request) {\n" +
                "        repository.save(" + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper.toDBO(request));\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    public " + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto update(" + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Dto) {\n" +
                "        var entity = " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper.toDBO(" + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Dto);\n" +
                "        repository.save(entity);\n" +
                "        return " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Mapper.toDTO(entity);\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    public void deleteById(String id) {\n" +
                "        repository.deleteById(id);\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("}");
        writer.close();
    }

    public static void createController() throws IOException {
        File file = new File(BASE_PATH + "/controller/" + ENTITY_CLASS_NAME_PASCAL_CASE + "Controller.java");
        if (file.exists()) return;
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("package " + BASE_PACKAGE + "controller;");
        runNewLine(2, writer);
        writer.write("import " + BASE_PACKAGE + "dto." + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto;\n" +
                "import " + BASE_PACKAGE + "dto.ApiResponseDto;\n" +
                "import " + BASE_PACKAGE + "dto.Create" + ENTITY_CLASS_NAME_PASCAL_CASE + "Request;\n" +
                "import " + BASE_PACKAGE + "service." + ENTITY_CLASS_NAME_PASCAL_CASE + "Service;\n" +
                "import org.springframework.http.HttpStatus;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "\n" +
                "import java.util.List;");
        runNewLine(2, writer);
        writer.write("@RestController\n" +
                "@RequestMapping(\"/api/v1/" + API_ROUTE + "\")\n" +
                "public class " + ENTITY_CLASS_NAME_PASCAL_CASE + "Controller {");
        runNewLine(2, writer);
        writer.write("    private final " + ENTITY_CLASS_NAME_PASCAL_CASE + "Service " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service;\n" +
                "\n" +
                "    public " + ENTITY_CLASS_NAME_PASCAL_CASE + "Controller(" + ENTITY_CLASS_NAME_PASCAL_CASE + "Service " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service) {\n" +
                "        this." + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service = " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service;\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    @GetMapping\n" +
                "    public ApiResponseDto<List<" + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto>> getAll() {\n" +
                "        return new ApiResponseDto<>(" + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service.getAll());\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    @GetMapping(\"/{id}\")\n" +
                "    public ApiResponseDto<" + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto> getById(@PathVariable String id) {\n" +
                "        return new ApiResponseDto<>(" + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service.getById(id));\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    @ResponseStatus(HttpStatus.CREATED)\n");
        writer.write("    @PostMapping\n" +
                "    public ApiResponseDto<?> add(@RequestBody Create" + ENTITY_CLASS_NAME_PASCAL_CASE + "Request request) {\n" +
                "        " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service.add(request);\n " +
                "       return new ApiResponseDto<>(null);\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    @PutMapping\n" +
                "    public ApiResponseDto<" + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto> update(@RequestBody " + ENTITY_CLASS_NAME_PASCAL_CASE + "Dto " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Dto) {\n" +
                "        return new ApiResponseDto<>(" + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service.update(" + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Dto));\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("    @DeleteMapping(\"/{id}\")\n" +
                "    public ApiResponseDto<?> deleteById(@PathVariable String id) {\n" +
                "        " + toLowerCaseFirstCharacter(ENTITY_CLASS_NAME_PASCAL_CASE) + "Service.deleteById(id);\n " +
                "       return new ApiResponseDto<>(null);\n" +
                "    }");
        runNewLine(2, writer);
        writer.write("}");
        writer.close();
    }

    private static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private static String toLowerCaseFirstCharacter(String str) {
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    private static void runNewLine(int count, BufferedWriter writer) throws IOException {
        for (int i = 0; i < count; i++) {
            writer.newLine();
        }
    }

}

