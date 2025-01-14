# kotlin-00-backing-fields

Vamos comparar o código Java com o Kotlin, destacar as diferenças e entender o conceito e vantagens dos **backing fields** no Kotlin.

---

### **Comparação de Java e Kotlin**
#### Código em Java:
```java
public class JavaEmployee {
    private final String firstName;
    private boolean fullTime;

    public JavaEmployee(String firstName) {
        this.firstName = firstName;
        this.fullTime = true;
    }

    public JavaEmployee(String firstName, boolean fullTime) {
        this.firstName = firstName;
        this.fullTime = fullTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }
}
```

#### Código em Kotlin:
```kotlin
class Employee(val firstName: String, fullTime: Boolean = true) {

    var fullTime = fullTime
        get() {
            println("Running the custom get")
            return field
        }
        set(value) {
            println("Running the custom set")
            field = value
        }
}
```

---

### **Principais diferenças**
1. **Declaração de Propriedades e Redução de Código**:
   - **Java**: É necessário declarar explicitamente os campos, escrever métodos `getter` e `setter` (ou gerar via IDE).
   - **Kotlin**: A declaração de propriedades com `val` ou `var` já gera automaticamente os `getters` e `setters`.

2. **Customização de Getters e Setters**:
   - **Java**: Para adicionar lógica aos métodos de acesso, é necessário sobrescrever manualmente o método.
   - **Kotlin**: O `getter` e o `setter` podem ser personalizados diretamente dentro da propriedade.

3. **Construtores**:
   - **Java**: É necessário criar um ou mais construtores explicitamente.
   - **Kotlin**: O construtor primário é integrado à definição da classe, reduzindo duplicação.

4. **Valores Padrão**:
   - **Java**: Não há suporte nativo para valores padrão em parâmetros de construtor.
   - **Kotlin**: O uso de valores padrão (`fullTime: Boolean = true`) elimina a necessidade de múltiplos construtores.

5. **Imutabilidade**:
   - A propriedade `firstName` em Kotlin é declarada como `val` (equivalente a `final` em Java), tornando-a imutável. Isso é mais conciso e explícito.

---

### **Backing Fields em Kotlin**
Um **backing field** é uma característica de Kotlin usada para evitar referências diretas a propriedades e garantir consistência ao acessar ou modificar seu valor. O campo gerado automaticamente é acessado usando a palavra-chave `field` dentro dos blocos `get()` e `set()`.

#### Exemplo:
```kotlin
var fullTime = fullTime
    get() {
        println("Running the custom get")
        return field // Referência ao backing field
    }
    set(value) {
        println("Running the custom set")
        field = value // Atualiza o backing field
    }
```

- **Sem o backing field (`field`)**: O acesso à propriedade (`fullTime`) seria recursivo e causaria uma exceção de "StackOverflowError".
- **Com o backing field**: O `field` mantém o estado interno da propriedade e pode ser acessado com segurança.

---

### **Vantagens do Backing Field em Kotlin**
1. **Evita Recursão Infinita**:
   - Quando `get()` ou `set()` são personalizados, o uso de `field` evita chamadas repetitivas à própria propriedade.

2. **Simplicidade e Confiabilidade**:
   - O gerenciamento do estado interno é automático e padronizado.

3. **Flexibilidade**:
   - Permite adicionar lógica customizada nos métodos de acesso sem perder a capacidade de usar o armazenamento interno.

4. **Conciso**:
   - Dispensa a necessidade de campos privados explícitos, comuns no Java.

---

### **Conclusão**
Kotlin simplifica o código, removendo redundâncias e promovendo maior legibilidade. O conceito de backing fields adiciona um nível de abstração que facilita a implementação de lógica personalizada nos métodos de acesso sem a necessidade de campos privados explícitos. A estrutura mais enxuta e expressiva do Kotlin torna-o uma excelente escolha para substituição ou complementação do Java, especialmente em projetos modernos. 🚀
