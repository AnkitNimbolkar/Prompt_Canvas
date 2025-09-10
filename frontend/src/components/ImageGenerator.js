import { useState } from "react";

export default function ImageGenerator() {
  const [prompt, setPrompt] = useState("");
  const [imageUrl, setImageUrl] = useState(null);
  const [loading, setLoading] = useState(false);
  const [history, setHistory] = useState([]);

  const handleGenerate = async () => {
    if (!prompt.trim()) return;

    setLoading(true);
    try {
      const res = await fetch("http://localhost:8082/api/images/generate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ prompt }),
      });

      if (!res.ok) throw new Error("Failed to generate image");

      const data = await res.json();
      setImageUrl(data.url);
      setHistory([data.url, ...history]);
    } catch (err) {
      console.error("Image generation failed:", err);
      alert("Failed to generate image. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="grid grid-cols-12 gap-6">
      {/* Left side */}
      <div className="col-span-4 space-y-4">
        <h2 className="text-2xl font-bold">Describe your image</h2>
        <textarea
          value={prompt}
          onChange={(e) => setPrompt(e.target.value)}
          className="w-full p-3 rounded-xl text-black"
          placeholder="E.g., A cyberpunk city at night, neon lights, futuristic cars..."
        />
        <button
          onClick={handleGenerate}
          className="w-full bg-indigo-600 hover:bg-indigo-700 text-white py-2 rounded-xl transition"
          disabled={loading}
        >
          {loading ? "Generating..." : "Generate Image"}
        </button>

        {/* Style Presets */}
        <div className="flex flex-wrap gap-2">
          {["Realistic", "Anime", "Sketch", "3D"].map((style) => (
            <button
              key={style}
              className="bg-gray-800 px-3 py-1 rounded-lg text-sm hover:bg-indigo-500"
              onClick={() => setPrompt(`${prompt} in ${style} style`)}
            >
              {style}
            </button>
          ))}
        </div>
      </div>

      {/* Right side */}
      <div className="col-span-8 space-y-4">
        <div className="bg-gray-800 h-[400px] flex items-center justify-center rounded-xl shadow-lg">
          {loading ? (
            <p className="animate-pulse">✨ Creating your masterpiece...</p>
          ) : imageUrl ? (
            <img
              src={imageUrl}
              alt="Generated"
              className="rounded-xl max-h-[400px] object-contain"
            />
          ) : (
            <p className="text-gray-400">Your image will appear here</p>
          )}
        </div>

        {/* History */}
        {history.length > 0 && (
          <div>
            <h3 className="text-xl font-semibold mb-2">Recent Creations</h3>
            <div className="grid grid-cols-4 gap-3">
              {history.map((url, idx) => (
                <img
                  key={idx}
                  src={url}
                  alt="Generated history"
                  className="rounded-lg cursor-pointer hover:scale-105 transition"
                  onClick={() => setImageUrl(url)}
                />
              ))}
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
