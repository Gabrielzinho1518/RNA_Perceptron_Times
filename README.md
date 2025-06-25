# RNA_Perceptron_Times

Este projeto implementa um **Perceptron** em Java.

## 📚 Descrição

O Perceptron é uma estrutura de rede neural que simula o comportamento de um neurônio artificial. Ele é treinado com exemplos rotulados para ajustar seus pesos e aprender a classificar corretamente novas entradas.

Este código implementa:
- Treinamento do perceptron com base em amostras (coordenadas X, Y + limiar)
- Teste de classificação para novos pontos

---

## Figura do Gráfico gerado: 

![figura_grafico](https://github.com/user-attachments/assets/b7da3efa-c76f-49a4-a6bc-ab4e96a92f2a)

## 🧩 Estrutura

### 📁 `Ponto.java`
Classe que representa uma amostra com:
- `x` e `y`: coordenadas da amostra (atributos)
- `limiar`: valor constante usado para o termo de bias

### 📁 `Perceptron.java`
Classe que implementa a rede Perceptron com:
- Lista de amostras (`List<Ponto>`)
- Lista de saídas desejadas (`List<Integer>`)
- Vetor de pesos
- Funções:
  - `treinar()`: ajusta os pesos conforme os dados
  - `testar(Ponto)`: classifica um novo ponto

---

## 🚀 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/perceptron-java.git

```
🧪 Testes
Você pode testar novos pontos utilizando o método testar(Ponto) e o sistema dirá a qual classe ele pertence:

Classe: 1 → Time Azul

Classe: -1 → Time Vermelho

🧑‍💻 Autor
Desenvolvido por [Gabriel Saccol] – @Gabrielzinho1518
