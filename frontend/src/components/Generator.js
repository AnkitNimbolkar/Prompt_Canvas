import React, { useState } from "react";

function Generator() {
  const [prompt, setPrompt] = useState("");
  const [imageUrl, setImageUrl] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleGenerate = async () => {
    if (!prompt) return;
    setLoading(true);
    setImageUrl(null);

    try {
      const response = await fetch("http://localhost:8082/api/images/generate", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ prompt }),
      });

      if (!response.ok) throw new Error("Failed to generate image");

      const data = await response.json();
      setImageUrl(data.imageUrl);
    } catch (err) {
      console.error("Error:", err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <section className="generator">
      <h2>Generate Your Image</h2>
      <input
        type="text"
        placeholder="Enter your prompt..."
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
      />
      <button onClick={handleGenerate}>Generate</button>
      <div>
        {loading && <p>Generating image...</p>}
        {imageUrl && <img src={imageUrl} alt="AI generated" style={{ maxWidth: "512px", borderRadius: "10px" }} />}
      </div>
    </section>
  );
}

export default Generator;
