# IN1007-PLP-Conjuntos-em-linguagens-funcionais

## Equipe
Pedro Henrique Almeida Girão Peixinho (phagp)

Renato Cavalcanti Domingues da Silva Filho (rcdsf)

## 1. Descrição do Projeto

### Objetivo
Este projeto tem como objetivo estender a Linguagem Funcional 1 (LF1) introduzindo o tipo de dado Set (Conjunto) e o suporte a operações clássicas de álgebra de conjuntos. Com isso, será possível declarar conjuntos finitos e aplicar operações de união, interseção e diferença de forma imutável. 
Além das operações básicas, a linguagem também recebeu operadores para:
- verificar pertencimento de elementos;
- verificar relação de subconjunto;
- realizar união distribuída (`unionAll`);
- realizar interseção distribuída (`interAll`).

### 2. Funcionalidades Implementadas

## Tipo de dado
- `Set`

**Operações de conjuntos**
* `union`
* `inter`
* `minus`
* `unionAll`
* `interAll`

**Predicados**
* `in`
* `subset`

---

## 2. Proposta de BNF

```bnf
Programa ::= Expressao

Expressao ::= Valor
            | ExpUnaria
            | ExpBinaria
            | ExpDeclaracao
            | Id
            | Aplicacao
            | IfThenElse

Valor ::= ValorConcreto

ValorConcreto ::= ValorInteiro
                | ValorBooleano
                | ValorString
                | ValorSet

ValorSet ::= "{" ListExp "}" | "{}"

ExpUnaria ::= "-" Expressao
            | "not" Expressao
            | "length" Expressao
            | "unionAll" Expressao
            | "interAll" Expressao

ExpBinaria ::= Expressao "+" Expressao
             | Expressao "-" Expressao
             | Expressao "and" Expressao
             | Expressao "or" Expressao
             | Expressao "==" Expressao
             | Expressao "++" Expressao
             | Expressao "union" Expressao
             | Expressao "inter" Expressao
             | Expressao "minus" Expressao
             | Expressao "in" Expressao
             | Expressao "subset" Expressao

ExpDeclaracao ::= "let" DeclaracaoFuncional "in" Expressao

DeclaracaoFuncional ::= DecVariavel
                      | DecFuncao
                      | DecComposta

DecVariavel ::= "var" Id "=" Expressao

DecFuncao ::= "fun" ListId "=" Expressao

DecComposta ::= DeclaracaoFuncional "," DeclaracaoFuncional

ListId ::= Id | Id ListId

Aplicacao ::= Id "(" ListExp ")"

ListExp ::= Expressao | Expressao "," ListExp

IfThenElse ::= "if" Expressao "then" Expressao "else" Expressao
```
