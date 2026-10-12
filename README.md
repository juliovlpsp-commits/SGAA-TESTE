# SGAA-TESTE - Sistema de Gestao Academica com Excecoes


## overview

App `CLI` em Java com 6 classes + 2 excecoes custom. Testa `ControleSono`, `RegistroEstudo`, `Componente`, `Anotacao` e `BlocoAnotacoes` via `SGAA.java`.

## exceptions

| exception | extends | quando lanca |
|---|---|---|
| `HorasInvalidasException` | `IllegalArgumentException` | horas/semanas/meta < 0 |
| `AnotacaoExistenteException` | `RuntimeException` | tema duplicado em `BlocoAnotacoes` |

## classes

| class | description |
|---|---|
| `ControleSono` | `descansado` if `avg >=26h/week` else `cansado` |
| `RegistroEstudo` | online hours per component (`0/120` default) |
| `Componente` | grades + weighted average |
| `Anotacao` | `tema: conteudo` |
| `BlocoAnotacoes` | circular buffer + `busca` sorted |
| `SGAA` | entry point with `try/catch` tests |

## technologies
- `java 17+`
- `plantuml` dark mode
- `git`

## structure
```
SGAA-TESTE/
├── lab3/
│   ├── SGAA.java
│   ├── ControleSono.java
│   ├── RegistroEstudo.java
│   ├── Componente.java
│   ├── Anotacao.java
│   ├── BlocoAnotacoes.java
│   └── exception/
│       ├── HorasInvalidasException.java
│       └── AnotacaoExistenteException.java
└── docs/
    ├── SGAA_UML.puml
    └── SGAA_UML.png
```

## how to run
```bash
javac -d out lab3/exception/*.java lab3/*.java
java -cp out lab3.SGAA
```

## author
JULIO EDUARDO MONTEIRO SILVA - UFCG
